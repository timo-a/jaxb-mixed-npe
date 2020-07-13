import javax.xml.bind.annotation.XmlValue;

public class Child {

	@XmlValue
	protected String value;
	
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
