import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MixedXMLReader {

	public static void main(String[] args) throws JAXBException, FileNotFoundException  {

		File xmlfile = new File("mixedcontent.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Parent.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Parent parent = (Parent) jaxbUnmarshaller.unmarshal(new FileInputStream(xmlfile));

/*		
Exception in thread "main" com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException: 3 counts of IllegalAnnotationExceptions
If a class has @XmlElement property, it cannot have @XmlValue property.
	this problem is related to the following location:
		at protected java.lang.String Child.value
		at Child
		at public java.util.List Parent.getChild()
		at Parent
	this problem is related to the following location:
		at public java.lang.String Child.getValue()
		at Child
		at public java.util.List Parent.getChild()
		at Parent
Invalid @XmlElementRef : Type "class Child" or any of its subclasses are not known to this context.
	this problem is related to the following location:
		at public java.util.List Parent.getChild()
		at Parent
Class has two properties of the same name "value"
	this problem is related to the following location:
		at public java.lang.String Child.getValue()
		at Child
		at public java.util.List Parent.getChild()
		at Parent
	this problem is related to the following location:
		at protected java.lang.String Child.value
		at Child
		at public java.util.List Parent.getChild()
		at Parent

	at com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException$Builder.check(IllegalAnnotationsException.java:91)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.getTypeInfoSet(JAXBContextImpl.java:445)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:277)
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
	at MixedXMLReader.main(MixedXMLReader.java:16)
*/
	}
}