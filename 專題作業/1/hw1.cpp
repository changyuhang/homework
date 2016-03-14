#include "cv.h"
#include "highgui.h"

void SkinDetection(IplImage *image) {
	CvScalar scalarImg;
	double Y, Cb, Cr;
	for (int i = 0; i < image->height; i++) {
		for (int j = 0; j < image->width; j++) {
			scalarImg = cvGet2D(image, i, j);
			//YCBCR�ഫ
			Y = (0 + scalarImg.val[2] * 0.299 + scalarImg.val[1] * 0.587 + scalarImg.val[0] * 0.114);	 //Y = 0 + R * 0.299 + G * 0.587 + B * 0.114
			Cb = (128 - scalarImg.val[2] * 0.169 - scalarImg.val[1] * 0.331 + scalarImg.val[0] * 0.499); //Cb = 128 - R * 0.169 - G * 0.331 + B * 0.499
			Cr = (128 + scalarImg.val[2] * 0.499 - scalarImg.val[1] * 0.418 - scalarImg.val[0] * 0.081); //Cr = 128 + R * 0.499 + G * 0.418 + B * 0.081

			if ((Cb >  98 && Cb < 142) && (Cr > 133 && Cr < 177)) //����d�� Cb ��120 +- 22 , Cr��155 +-22
				cvSet2D(image, i, j, cvScalar(255, 255, 255)); //���p�O���� �]�w���զ�(255,255,255)
			else
				cvSet2D(image, i, j, cvScalar(0, 0, 0)); //���O���� �]�w���¦�(0,0,0)
		}
	}
}

int main() {
	IplImage* img = cvLoadImage("a.jpg");
	cvShowImage("original", img);
	SkinDetection(img);
	cvShowImage("final", img);
	cvWaitKey(0);
	return 0;
}