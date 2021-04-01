import { Component, OnInit } from '@angular/core';
import { FileuploadService } from '../fileupload.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: any;
  showProductsTable = false;

  product = {
    productId: 0,
    productName: '',
    amazonProduct: {
      amazonProductId: 0,
      articleNumber: '',
      exported: false,
    },
  };
  constructor(private uploadFileService: FileuploadService) {}
  fileToUpload: any;
  uploadText: String = '';
  uploaded = false;
  formData: FormData = new FormData();
  ngOnInit(): void {}
  fileUpload(event: any) {
    const files = event.target.files;

    console.log(event.target.files);
    this.fileToUpload = files.item(0);

    this.formData.append('file', this.fileToUpload);
    this.formData.append('name', this.fileToUpload.name);
    console.log(this.fileToUpload.name);
    console.log(this.formData);
    // this.uploadFileToActivity(formData);
  }
  uploadFileToActivity() {
    if (this.formData === null) {
      this.uploadText = 'Please select file';
    } else {
      this.uploadText = 'File Uploaded';
    }

    this.uploaded = true;
    this.uploadFileService.uploadFile(this.formData).subscribe(
      (response) => {
        console.log(response);
      },
      (err) => {
        console.log(err);
      }
    );
  }
  showproducts() {
    this.uploadFileService.getAllProducts().subscribe((response) => {
      this.products = response;
      this.showProductsTable = true;
    });
  }
  updateStatusOfProduct(data: any) {
    console.log(data.amazonProduct.exported);
    this.product.productId = data.productId;
    this.product.productName = data.productName;
    this.product.amazonProduct.amazonProductId =
      data.amazonProduct.amazonProductId;
    this.product.amazonProduct.articleNumber = data.amazonProduct.articleNumber;
    this.product.amazonProduct.exported = !data.amazonProduct.exported;
    console.log(this.product);
    this.uploadFileService.updateProduct(this.product).subscribe(
      (response) => {
        console.log(response);
      },
      (err) => {
        console.log(err);
      }
    );
    this.showproducts();
  }
  deleteProduct(data: any) {
    this.uploadFileService
      .deleteProduct(data.amazonProduct.amazonProductId)
      .subscribe(
        (response) => {
          console.log(response);
          
        },
        (err) => {
          console.log(err);
        }
      );
   
  }
}
