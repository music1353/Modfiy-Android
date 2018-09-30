# Modify - 簡易的修圖軟體

使用Android撰寫，包含濾鏡、選轉的應用程式

## 特色

* 包含藝術風、模糊、筆觸、雜訊、像素、銳利化、素描、風格化、紋理等多種濾鏡

* 自行搭建濾鏡Kernel（此列舉幾種濾鏡kernel）

  * 黑白

    ~~~java
    final static float black_white[] = {0.8f, 1.6f, 0.2f, 0, -163.9f, 0.8f, 1.6f, 0.2f, 0, -163.9f, 0.8f, 1.6f, 0.2f, 0, -163.9f, 0, 0, 0, 1.0f, 0};
    ~~~

  * 懷舊

    ~~~java
    final static float nostalgia[] = {0.2f, 0.5f, 0.1f, 0, 40.8f, 0.2f, 0.5f, 0.1f, 0, 40.8f, 0.2f, 0.5f, 0.1f, 0, 40.8f, 0, 0, 0, 1, 0};
    ~~~

  * 歌德

    ~~~java
    final static float gothic[] = {1.9f, -0.3f, -0.2f, 0, -87.0f, -0.2f, 1.7f, -0.1f, 0, -87.0f, -0.1f, -0.6f, 2.0f, 0, -87.0f, 0, 0, 0, 1.0f, 0};
    ~~~

* 圖片旋轉功能

* RGB565壓縮圖檔

* 簡易快速保存圖片

## 螢幕截圖

<img src="https://imgur.com/zx9r2rA.jpg" width="300px"/> <img src="https://imgur.com/uLUyet2.jpg" width="300px"/>

<img src="https://imgur.com/nYdSYWI.jpg" width="300px"/> <img src="https://imgur.com/9Natnpl.jpg" width="300px"/>

<img src="https://imgur.com/OKX5bdQ.jpg" width="300px"/> <img src="https://imgur.com/Zkyp93j.jpg" width="300px"/> 

<img src="https://imgur.com/x9NhWUX.jpg" width="300px"/> <img src="https://imgur.com/LpZn3zc.jpg" width="300px"/>  

