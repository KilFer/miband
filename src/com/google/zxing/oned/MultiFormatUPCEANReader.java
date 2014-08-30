package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader extends OneDReader
{
  private final UPCEANReader[] a;

  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap)
  {
    Collection localCollection;
    ArrayList localArrayList;
    if (paramMap == null)
    {
      localCollection = null;
      localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if (!localCollection.contains(BarcodeFormat.EAN_13))
          break label190;
        localArrayList.add(new EAN13Reader());
      }
    }
    while (true)
    {
      if (localCollection.contains(BarcodeFormat.EAN_8))
        localArrayList.add(new EAN8Reader());
      if (localCollection.contains(BarcodeFormat.UPC_E))
        localArrayList.add(new UPCEReader());
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new EAN13Reader());
        localArrayList.add(new EAN8Reader());
        localArrayList.add(new UPCEReader());
      }
      this.a = ((UPCEANReader[])localArrayList.toArray(new UPCEANReader[localArrayList.size()]));
      return;
      localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
      break;
      label190: if (localCollection.contains(BarcodeFormat.UPC_A))
        localArrayList.add(new UPCAReader());
    }
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt = UPCEANReader.a(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int i = arrayOfUPCEANReader.length;
    int j = 0;
    while (j < i)
    {
      UPCEANReader localUPCEANReader = arrayOfUPCEANReader[j];
      try
      {
        Result localResult = localUPCEANReader.decodeRow(paramInt, paramBitArray, arrayOfInt, paramMap);
        int k;
        Collection localCollection;
        if ((localResult.getBarcodeFormat() == BarcodeFormat.EAN_13) && (localResult.getText().charAt(0) == '0'))
        {
          k = 1;
          if (paramMap != null)
            break label144;
          localCollection = null;
          label81: if ((localCollection != null) && (!localCollection.contains(BarcodeFormat.UPC_A)))
            break label161;
        }
        label144: label161: for (int m = 1; ; m = 0)
        {
          if ((k == 0) || (m == 0))
            break label167;
          return new Result(localResult.getText().substring(1), null, localResult.getResultPoints(), BarcodeFormat.UPC_A);
          k = 0;
          break;
          localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
          break label81;
        }
        label167: return localResult;
      }
      catch (ReaderException localReaderException)
      {
        j++;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final void reset()
  {
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int i = arrayOfUPCEANReader.length;
    for (int j = 0; j < i; j++)
      arrayOfUPCEANReader[j].reset();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.MultiFormatUPCEANReader
 * JD-Core Version:    0.6.2
 */