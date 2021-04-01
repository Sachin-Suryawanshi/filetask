import { Component, OnInit } from '@angular/core';
import { FileuploadService } from './fileupload.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  uploadText: String = '';
  amazonProduct = {
    amazonProductId: 0,
    articleNumber: '',
    isExported: false,
  };
  showData = false;
  amazonProducts: any;
  formData: FormData = new FormData();
  title = 'fileupload';
  fileToUpload: any;
  uploaded = false;
  constructor(private fileuploadservice: FileuploadService) {}
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
    this.fileuploadservice.uploadFile(this.formData).subscribe(
      (response) => {
        console.log(response);
      },
      (err) => {
        console.log(err);
      }
    );
  }
  viewAmazonProductDetails() {
    this.showData = true;
    this.fileuploadservice.getAllAmazonProducts().subscribe(
      (response) => {
        this.amazonProducts = response;
        console.log(response);
      },
      (err) => {
        console.log(err);
      }
    );
  }
  updateAmazonProductStatus(data: any) {
    this.amazonProduct.amazonProductId = data.amazonProductId;
    this.amazonProduct.articleNumber = data.articleNumber;
    this.amazonProduct.isExported = !data.isExported;
    console.log('inside update amzon :' + this.amazonProduct.isExported);
    this.fileuploadservice.updateAmazonProduct(this.amazonProduct).subscribe(
      (response) => {
        console.log(response);
      },
      (err) => {
        console.log(err);
      }
    );
    this.viewAmazonProductDetails();
  }
}
