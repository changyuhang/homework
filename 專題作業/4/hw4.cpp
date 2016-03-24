#include "opencv2/opencv.hpp"
#include<iostream>
#include<cmath>
#define h imginital->height
#define w imginital->width
#define throughput_sc 40
#define throughput 80
#define nh cvRound(abs(h*vcos)+abs(w*vsin))
#define nw cvRound(abs(w*vcos)+abs(h*vsin))
#define fh imgfinal->height
#define fw imgfinal->width

void main() {
	IplImage *imginital = cvLoadImage("a.jpg", 1);
	IplImage *imgfinal;
	IplImage *imganswer;

	double turn;
	std::cout << "Degree:";
	std::cin >> turn;
	turn = turn*(CV_PI / 180);
	double vcos = cos(turn), vsin = sin(turn);
	double offset_x, offset_y;

	imganswer = cvCreateImage(CvSize(nw, nh), IPL_DEPTH_8U, 3);
	imgfinal = cvCreateImage(CvSize(w, h), IPL_DEPTH_8U, 3);

	for (int i = 0; i < imginital->height; i++) {
		for (int j = 1; j < imginital->width; j++) {
			int imginital_imgData = imginital->widthStep * i + j * 3;
			int imgfinal_imgData = imgfinal->widthStep * i + j * 3;
			int tempb = abs(imginital->imageData[imginital_imgData] - imginital->imageData[imginital_imgData - 3]);
			int tempg = abs(imginital->imageData[imginital_imgData + 1] - imginital->imageData[imginital_imgData - 2]);
			int tempr = abs(imginital->imageData[imginital_imgData + 2] - imginital->imageData[imginital_imgData - 1]);
			int temp = tempb + tempg + tempr;
			if (tempb>throughput_sc || tempg > throughput_sc || tempr > throughput_sc || temp > throughput) {
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
		for (int i = 1; i < imgfinal->height; i++) {
			int imginital_imgData = imginital->widthStep * i + j * 3;
			int imgfinal_imgData = imgfinal->widthStep * i + j * 3;
			int tempb = abs(imginital->imageData[imginital_imgData] - imginital->imageData[imginital_imgData - 3 - imginital->widthStep]);
			int tempg = abs(imginital->imageData[imginital_imgData + 1] - imginital->imageData[imginital_imgData - 2 - imginital->widthStep]);
			int tempr = abs(imginital->imageData[imginital_imgData + 2] - imginital->imageData[imginital_imgData - 1 - imginital->widthStep]);
			int temp = tempb + tempg + tempr;
			if (tempb>throughput_sc || tempg > throughput_sc || tempr > throughput_sc || temp > throughput) {
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


	offset_x = -nw / 2 * vcos - nh / 2 * vsin + w / 2;
	offset_y = nw / 2 * vsin - nh / 2 * vcos + h / 2;

	for (int ny = 0; ny < imganswer->height; ny++) {
		for (int nx = 0; nx < imganswer->width; nx++) {
			int x = (int)(nx*vcos + ny*vsin + 0.5 + offset_x);
			int y = (int)(-nx*vsin + ny*vcos + 0.5 + offset_y);
			int imgfinal_imgData = imgfinal->widthStep * y + x * 3;
			int imganswer_imgData = imganswer->widthStep *ny + nx * 3;
			if (x < 0 || y < 0 || x >= imgfinal->width || y >= imgfinal->height) {
				imganswer->imageData[imganswer_imgData] = 127; imganswer->imageData[imganswer_imgData + 1] = 127; imganswer->imageData[imganswer_imgData + 2] = 127;
			}
			else {
				imganswer->imageData[imganswer_imgData] = imgfinal->imageData[imgfinal_imgData];
				imganswer->imageData[imganswer_imgData + 1] = imgfinal->imageData[imgfinal_imgData + 1];
				imganswer->imageData[imganswer_imgData + 2] = imgfinal->imageData[imgfinal_imgData + 2];
			}
		}
	}

	cvShowImage("Original", imginital);
	cvShowImage("'Result", imganswer);
	cvWaitKey(0);
}