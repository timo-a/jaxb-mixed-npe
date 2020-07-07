import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parent")

public class Parent {

	protected List<Child> child = new ArrayList<>();
	protected List<String> text = new ArrayList<>();

	@XmlElementRef(name = "child", type = Child.class)
	public List<Child> getChild() {
		return child;
	}

	@XmlMixed
	public List<String> getText() {
		return text;
	}

	public void setChild(Child value) {
		this.child.add(value);
	}

	public void setText(String value) {
		this.text.add(value);

	}
}