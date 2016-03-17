#include "opencv2/opencv.hpp"
#include<iostream>
#include<cmath>
#define h imginital->height
#define w imginital->width
#define throughput_sc 30
#define throughput 60

void main() {
	IplImage *imginital = cvLoadImage("test2.jpg", 1);
	IplImage *imgfinal;

	imgfinal = cvCreateImage(CvSize(w, h), IPL_DEPTH_8U, 3);

	for (int i = 0; i < imginital->height; i++) {
		for (int j = 1; j <= imginital->width; j++) {
			int imginital_imgData = imginital->widthStep * i + j * 3;
			int imgfinal_imgData = imgfinal->widthStep * i + j * 3;
			int tempb = abs(imginital->imageData[imginital_imgData] - imginital->imageData[imginital_imgData - 3]);
			int tempg = abs(imginital->imageData[imginital_imgData + 1] - imginital->imageData[imginital_imgData - 2]);
			int tempr = abs(imginital->imageData[imginital_imgData + 2] - imginital->imageData[imginital_imgData - 1]);
			int temp = tempb + tempg + tempr;
			if (tempb>throughput_sc || tempg>throughput_sc || tempr>throughput_sc || temp>throughput) {
				imgfinal->imageData[imginital_imgData] = 255;
				imgfinal->imageData[imginital_imgData] = 255;
				imgfinal->imageData[imginital_imgData] = 255;
			}
			else {
				imgfinal->imageData[imgfinal_imgData] = 0;
				imgfinal->imageData[imgfinal_imgData + 1] = 0;
				imgfinal->imageData[imgfinal_imgData + 2] = 0;
			}
		}
	}
	for (int j = 0; j < imgfinal->width; j++) {
		for (int i = 1; i <= imgfinal->height; i++) {
			int imginital_imgData = imginital->widthStep * i + j * 3;
			int imgfinal_imgData = imgfinal->widthStep * i + j * 3;
			int tempb = abs(imginital->imageData[imginital_imgData] - imginital->imageData[imginital_imgData - 3 - imginital->widthStep]);
			int tempg = abs(imginital->imageData[imginital_imgData + 1] - imginital->imageData[imginital_imgData - 2 - imginital->widthStep]);
			int tempr = abs(imginital->imageData[imginital_imgData + 2] - imginital->imageData[imginital_imgData - 1 - imginital->widthStep]);
			int temp = tempb + tempg + tempr;
			if (tempb>throughput_sc || tempg>throughput_sc || tempr>throughput_sc || temp>throughput) {
				imgfinal->imageData[imgfinal_imgData] = 255;
				imgfinal->imageData[imgfinal_imgData + 1] = 255;
				imgfinal->imageData[imgfinal_imgData + 2] = 255;
			}
			else {
				imgfinal->imageData[imgfinal_imgData] = 0;
				imgfinal->imageData[imgfinal_imgData + 1] = 0;
				imgfinal->imageData[imgfinal_imgData + 2] = 0;
			}
		}
	}
	cvShowImage("Original", imginital);
	cvShowImage("'Result", imgfinal);
	cvWaitKey(0);
}