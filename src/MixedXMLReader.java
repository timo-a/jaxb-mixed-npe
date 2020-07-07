import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

public class MixedXMLReader {

	public static void main(String[] args) throws JAXBException {
		/* proof that it works for child */
		String content0 = "<child>I am the child element</child>";
		JAXBContext context0 = JAXBContext.newInstance(Child.class);
		JAXBElement<Child> root0 = context0.createUnmarshaller().unmarshal(new StreamSource(new StringReader(content0)),
				Child.class);
		System.out.println(root0.getValue().toString());

		/* Here, I get the error below */
		String content = "<parent>before<child>I am the child element</child>after.</parent>";
		JAXBContext context = JAXBContext.newInstance(Parent.class);
		JAXBElement<Parent> root = context.createUnmarshaller().unmarshal(new StreamSource(new StringReader(content)),
				Parent.class);
		System.out.println(root.getValue().getText().get(0));

/*		
Exception in thread "main" java.lang.NullPointerException
	at com.sun.xml.internal.bind.v2.runtime.property.PropertyFactory.create(PropertyFactory.java:113)
	at com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl.<init>(ClassBeanInfoImpl.java:166)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.getOrCreate(JAXBContextImpl.java:488)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:305)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:124)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl$JAXBContextBuilder.build(JAXBContextImpl.java:1123)
	at com.sun.xml.internal.bind.v2.ContextFactory.createContext(ContextFactory.java:147)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:247)
	at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:234)
	at javax.xml.bind.ContextFinder.find(ContextFinder.java:462)
	at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:641)
	at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:584)
	at MixedXMLReader.main(MixedXMLReader.java:20)
*/
	}
}