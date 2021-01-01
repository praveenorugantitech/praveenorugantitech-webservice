package com.praveen.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.blogspot.praveenoruganti.patient.Patient;


public class JAXBDemo {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();

			Patient patient = new Patient();
			patient.setId(1);
			patient.setName("Praveen Oruganti");

			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

			System.out.println(writer.toString());

			Unmarshaller unMarshaller = context.createUnmarshaller();

			Patient patientResult = (Patient) unMarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.print(patientResult.getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}