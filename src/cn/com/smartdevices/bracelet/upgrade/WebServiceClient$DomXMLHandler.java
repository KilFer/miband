package cn.com.smartdevices.bracelet.upgrade;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class WebServiceClient$DomXMLHandler
{
  private DocumentBuilder a;

  private static DocumentBuilder a()
  {
    return DocumentBuilderFactory.newInstance().newDocumentBuilder();
  }

  public Element parseXml(InputStream paramInputStream)
  {
    try
    {
      if (this.a == null)
        this.a = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Element localElement = this.a.parse(new BufferedInputStream(paramInputStream)).getDocumentElement();
      return localElement;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
      return null;
    }
    catch (SAXException localSAXException)
    {
      localSAXException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.WebServiceClient.DomXMLHandler
 * JD-Core Version:    0.6.2
 */