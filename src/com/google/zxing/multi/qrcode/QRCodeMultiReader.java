package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.Decoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader extends QRCodeReader
  implements MultipleBarcodeReader
{
  private static final Result[] a = new Result[0];

  public final Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap)
  {
    return decodeMultiple(paramBinaryBitmap, null);
  }

  public final Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    DetectorResult[] arrayOfDetectorResult = new MultiDetector(paramBinaryBitmap.getBlackMatrix()).detectMulti(paramMap);
    int i = arrayOfDetectorResult.length;
    int j = 0;
    while (true)
    {
      DetectorResult localDetectorResult;
      if (j < i)
        localDetectorResult = arrayOfDetectorResult[j];
      try
      {
        DecoderResult localDecoderResult = getDecoder().decode(localDetectorResult.getBits());
        ResultPoint[] arrayOfResultPoint = localDetectorResult.getPoints();
        Result localResult = new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.QR_CODE);
        List localList = localDecoderResult.getByteSegments();
        if (localList != null)
          localResult.putMetadata(ResultMetadataType.BYTE_SEGMENTS, localList);
        String str = localDecoderResult.getECLevel();
        if (str != null)
          localResult.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        localArrayList.add(localResult);
        label145: j++;
        continue;
        if (localArrayList.isEmpty())
          return a;
        return (Result[])localArrayList.toArray(new Result[localArrayList.size()]);
      }
      catch (ReaderException localReaderException)
      {
        break label145;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.multi.qrcode.QRCodeMultiReader
 * JD-Core Version:    0.6.2
 */