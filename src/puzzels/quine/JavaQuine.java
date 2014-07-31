package puzzels.quine;

import java.io.StringWriter;
import java.io.Writer;

import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.PlainTextOutput;

public class JavaQuine {
	
	public static void main(String[] args) {
		printClass(JavaQuine.class);
	}
	
	private static final void printClass(Class<?> c) {
		Writer writer = new StringWriter();
		Decompiler.decompile(c.getName().replace(".", "/"), new PlainTextOutput(writer ));
		
		System.out.println(writer.toString());
		
	}
	
}