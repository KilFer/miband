package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader
  implements Reader
{
  private Map<DecodeHintType, ?> a;
  private Reader[] b;

  private Result a(BinaryBitmap paramBinaryBitmap)
  {
    if (this.b != null)
    {
      Reader[] arrayOfReader = this.b;
      int i = arrayOfReader.length;
      int j = 0;
      while (j < i)
      {
        Reader localReader = arrayOfReader[j];
        try
        {
          Result localResult = localReader.decode(paramBinaryBitmap, this.a);
          return localResult;
        }
        catch (ReaderException localReaderException)
        {
          j++;
        }
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap)
  {
    setHints(null);
    return a(paramBinaryBitmap);
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    setHints(paramMap);
    return a(paramBinaryBitmap);
  }

  public final Result decodeWithState(BinaryBitmap paramBinaryBitmap)
  {
    if (this.b == null)
      setHints(null);
    return a(paramBinaryBitmap);
  }

  public final void reset()
  {
    if (this.b != null)
    {
      Reader[] arrayOfReader = this.b;
      int i = arrayOfReader.length;
      for (int j = 0; j < i; j++)
        arrayOfReader[j].reset();
    }
  }

  public final void setHints(Map<DecodeHintType, ?> paramMap)
  {
    this.a = paramMap;
    int i;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      if (paramMap != null)
        break label512;
    }
    label512: for (Collection localCollection = null; ; localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS))
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        int j;
        if ((!localCollection.contains(BarcodeFormat.UPC_A)) && (!localCollection.contains(BarcodeFormat.UPC_E)) && (!localCollection.contains(BarcodeFormat.EAN_13)) && (!localCollection.contains(BarcodeFormat.EAN_8)) && (!localCollection.contains(BarcodeFormat.CODE_39)) && (!localCollection.contains(BarcodeFormat.CODE_93)) && (!localCollection.contains(BarcodeFormat.CODE_128)) && (!localCollection.contains(BarcodeFormat.ITF)) && (!localCollection.contains(BarcodeFormat.RSS_14)))
        {
          boolean bool = localCollection.contains(BarcodeFormat.RSS_EXPANDED);
          j = 0;
          if (!bool);
        }
        else
        {
          j = 1;
        }
        if ((j != 0) && (i == 0))
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        if (localCollection.contains(BarcodeFormat.QR_CODE))
          localArrayList.add(new QRCodeReader());
        if (localCollection.contains(BarcodeFormat.DATA_MATRIX))
          localArrayList.add(new DataMatrixReader());
        if (localCollection.contains(BarcodeFormat.AZTEC))
          localArrayList.add(new AztecReader());
        if (localCollection.contains(BarcodeFormat.PDF_417))
          localArrayList.add(new PDF417Reader());
        if (localCollection.contains(BarcodeFormat.MAXICODE))
          localArrayList.add(new MaxiCodeReader());
        if ((j != 0) && (i != 0))
          localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      if (localArrayList.isEmpty())
      {
        if (i == 0)
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        localArrayList.add(new QRCodeReader());
        localArrayList.add(new DataMatrixReader());
        localArrayList.add(new AztecReader());
        localArrayList.add(new PDF417Reader());
        localArrayList.add(new MaxiCodeReader());
        if (i != 0)
          localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      this.b = ((Reader[])localArrayList.toArray(new Reader[localArrayList.size()]));
      return;
      i = 0;
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.MultiFormatReader
 * JD-Core Version:    0.6.2
 */