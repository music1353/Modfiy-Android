### Modify - 你最好的修圖幫手

--------

- FilterUtils.java：各種濾鏡的方法包裝在這
- ModifyActivity.java
  主要修圖的activity，下列為幾個重要的方法
  - void setModifyBtns()：設置及綁定濾鏡滑動按鈕
  - void setRotateBtns()：設置及綁定旋轉滑動按鈕
  - Bitmap getCurrentBitmap()：拿到當下畫面上的圖片(Bitmap)
  - Bitmap RGB565(Uri)：圖片壓縮，減少內存消耗
  - File tempFileImage(Context, Bitmap, String)：存圖片在暫時的資料夾，返回圖片File位置
  - void recycleBitmap(Bitmap)：回收Bitmap內存
- CompleteActivity.java
  完成修圖後的activity
  - void cleanTempImage()：清空modify/temp/內的所有圖片
  - void saveImage(Context, Bitmap)：儲存圖片至modify/images/