package esa.mep.downloader.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DownloaderWebService", targetNamespace = "http://esa.int/ese/services/downloader", wsdlLocation = "file:/D:/users/cnl/git/mep/Downloader/Downloader/mavenproject2/src/wsdl/Downloader.wsdl")
public class DownloaderWebService
    extends Service
{

    private final static URL DOWNLOADERWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException DOWNLOADERWEBSERVICE_EXCEPTION;
    private final static QName DOWNLOADERWEBSERVICE_QNAME = new QName("http://esa.int/ese/services/downloader", "DownloaderWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/users/cnl/git/mep/Downloader/Downloader/mavenproject2/src/wsdl/Downloader.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DOWNLOADERWEBSERVICE_WSDL_LOCATION = url;
        DOWNLOADERWEBSERVICE_EXCEPTION = e;
    }

    public DownloaderWebService() {
        super(__getWsdlLocation(), DOWNLOADERWEBSERVICE_QNAME);
    }

    public DownloaderWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DOWNLOADERWEBSERVICE_QNAME, features);
    }

    public DownloaderWebService(URL wsdlLocation) {
        super(wsdlLocation, DOWNLOADERWEBSERVICE_QNAME);
    }

    public DownloaderWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DOWNLOADERWEBSERVICE_QNAME, features);
    }

    public DownloaderWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DownloaderWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DownloaderWebServicePortType
     */
    @WebEndpoint(name = "DownloaderWebServiceInterfacePort")
    public DownloaderWebServicePortType getDownloaderWebServiceInterfacePort() {
        return super.getPort(new QName("http://esa.int/ese/services/downloader", "DownloaderWebServiceInterfacePort"), DownloaderWebServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DownloaderWebServicePortType
     */
    @WebEndpoint(name = "DownloaderWebServiceInterfacePort")
    public DownloaderWebServicePortType getDownloaderWebServiceInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://esa.int/ese/services/downloader", "DownloaderWebServiceInterfacePort"), DownloaderWebServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DOWNLOADERWEBSERVICE_EXCEPTION!= null) {
            throw DOWNLOADERWEBSERVICE_EXCEPTION;
        }
        return DOWNLOADERWEBSERVICE_WSDL_LOCATION;
    }

}
