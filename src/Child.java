import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "child")
public class Child {

	@XmlValue
	private String content;

	@Override
	public String toString() {
		return content;
	}
}
