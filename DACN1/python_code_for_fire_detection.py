# -*- coding: utf-8 -*-
"""
Created on Fri Sep  4 23:02:17 2020

@author: HP USER
"""



import numpy as np
import cv2
#import serial
import time
fire_cascade = cv2.CascadeClassifier("D://DuAnVKU//Fire-Detection-using-HAAR-Cascade-Classifier-in-OpenCV-main//cascade.xml")
#cascade.xml is the classifier file that contains the parameters of classifier
#checks for fire detection

#ser1 = serial.Serial('COM5',9600) #select the COM port number on which arduino is connected

# cap = cv2.VideoCapture(0)
cap = cv2.VideoCapture("C://Users//TVTHANH//Desktop//test_fire_2.mp4") #start video capturing
count = 0
while cap.isOpened():
    ret, img = cap.read() #capture a frame 
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY) #convert image to grayscale

    # gray = cv2.equalizeHist(gray) #cân bằng ảnh xám
    # ret, bin = cv2.threshold(gray, 60, 255, cv2.THRESH_BINARY) #chọn ngưỡng
    color = cv2.cvtColor(img, cv2.COLOR_BGR2RGB )#chuyển đổi sang thang màu RGB
    imgYCC = cv2.cvtColor(img, cv2.COLOR_BGR2YCR_CB) # chuyển đổi sang hệ màu YCrCb
    phanvung_color = cv2.inRange(color,(190,100,0),(255,255,140))#phân vùng theo ngưỡng màu
    # phanvung_YCC = cv2.inRange(imgYCC,(150,0),(255,120))
    img2 = cv2.bitwise_and(img,img,mask = phanvung_color) # tách đối tượng ảnh gốc
    img2 = cv2.cvtColor(img2,cv2.COLOR_BGR2GRAY)
    fire = fire_cascade.detectMultiScale(gray, 12, 5) #test for fire detection
    for (x,y,w,h) in fire:
        cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2) #highlight the area of image with fire
        roi_gray = img2[y:y+h, x:x+w]
        roi_color = img[y:y+h, x:x+w]
        cv2.imshow('detectfire',roi_color)

        count_pixel = float(cv2.countNonZero(roi_gray))
        if (count_pixel>50):
            cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),2) #highlight the area of image with fire
            print( 'Fire is detected..!' + str(count)) 
            count = count + 1
        #ser1.write(str.encode('p')) #write 'p' on serial COM port to arduino
        time.sleep(0.2) #wait
        
        

    cv2.imshow('img',img)
    # cv2.imshow('img2',img2)
    cv2.imshow('phanvung_color',phanvung_color)
    #ser1.write(str.encode('s')) #write 's' if there is no fire
    k = cv2.waitKey(100) & 0xff
    if k == 27:
       break

#ser1.close()
cap.release()
cv2.destroyAllWindows()

