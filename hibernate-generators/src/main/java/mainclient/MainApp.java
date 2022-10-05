package mainclient;

import entities.annotation.*;
import entities.usingcustomgenerator.Product_Using_Custom_Generator;
import entities.xml.*;
import util.DB_Operations;

public class MainApp {

	public static void main(String[] args) {
		DB_Operations db_operations = new DB_Operations();

//		Product_Using_AUTO_Generator_Annotations generatorAnnotations = new Product_Using_AUTO_Generator_Annotations();
//		generatorAnnotations.setProductName("Abc");
//		generatorAnnotations.setProductPrice("1421");
//		db_operations.createRecord(generatorAnnotations);
//
//		Product_Using_Sequence_Generator_Annotations sequence_generator_annotations = new Product_Using_Sequence_Generator_Annotations();
//		sequence_generator_annotations.setProductName("Mouse");
//		sequence_generator_annotations.setProductPrice("145687");
//		db_operations.createRecord(sequence_generator_annotations);
//
//		Product_Using_Table_Generator_Annotations table_generator_annotations = new Product_Using_Table_Generator_Annotations();
//		table_generator_annotations.setProductName("Mouse");
//		table_generator_annotations.setProductPrice("145687");
//		db_operations.createRecord(table_generator_annotations);
//
//		Product_Using_Identity_Generator_Annotations identity_generator_annotations = new Product_Using_Identity_Generator_Annotations();
//		identity_generator_annotations.setProductName("Mouse");
//		identity_generator_annotations.setProductPrice("145687");
//		db_operations.createRecord(identity_generator_annotations);
//
//		Product_Using_Increment_Generator_XML productUsingIncrementGenerator = new Product_Using_Increment_Generator_XML();
//		productUsingIncrementGenerator.setProductName("Product_Using_Increment_Generator_XML");
//		productUsingIncrementGenerator.setProductPrice("10500");
//		db_operations.createRecord(productUsingIncrementGenerator);
//
//		Product_Using_Sequence_Generator_XML product_using_sequence_generator_xml = new Product_Using_Sequence_Generator_XML();
//		product_using_sequence_generator_xml.setProductName("product_using_sequence_generator");
//		product_using_sequence_generator_xml.setProductPrice("Keyboard");
//		db_operations.createRecord(product_using_sequence_generator_xml);
//
//		Product_Using_Native_Generator_XML usingNativeGeneratorXml = new Product_Using_Native_Generator_XML();
//		usingNativeGeneratorXml.setProductName("usingNativeGeneratorXml");
//		usingNativeGeneratorXml.setProductPrice("Keyboard");
//		db_operations.createRecord(usingNativeGeneratorXml);
//
//		Product_Using_Identity_Generator_XML usingIdentityGeneratorXml = new Product_Using_Identity_Generator_XML();
//		usingIdentityGeneratorXml.setProductName("usingIdentityGeneratorXml");
//		usingIdentityGeneratorXml.setProductPrice("Keyboard");
//		db_operations.createRecord(usingIdentityGeneratorXml);
//
//		Product_Using_UUID_Generator_XML usingUuidGeneratorXml = new Product_Using_UUID_Generator_XML();
//		usingUuidGeneratorXml.setProductName("usingUuidGeneratorXml");
//		usingUuidGeneratorXml.setProductPrice("Keyboard");
//		db_operations.createRecord(usingUuidGeneratorXml);
//
//		Product_Using_Foreign_Generator_XML productUsingForeignGeneratorXml = new Product_Using_Foreign_Generator_XML();
//		Lab lab = new Lab();
//		lab.setLabName("CS Lab");
//		productUsingForeignGeneratorXml.setProductName("usingUuidGeneratorXml");
//		productUsingForeignGeneratorXml.setProductPrice("Keyboard");
//		productUsingForeignGeneratorXml.setLab(lab);
//		productUsingForeignGeneratorXml.setLab(lab);
//		db_operations.createRecord(productUsingForeignGeneratorXml);

		Product_Using_Custom_Generator productUsingCustomGenerator = new Product_Using_Custom_Generator();
		productUsingCustomGenerator.setProductName("productUsingCustomGenerator");
		productUsingCustomGenerator.setProductPrice("5412");
		db_operations.createRecord(productUsingCustomGenerator);
	}

}
