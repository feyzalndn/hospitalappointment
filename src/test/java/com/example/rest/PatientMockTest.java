import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.persistence.domain.Patient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:patient-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
class PatientControllerIntegrationTest {


	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	private final Patient TEST_PATIENT = new Patient();

	private final Patient TEST_SAVED_PATIENT = new Patient();

	@Test
	public void testAddPatient() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/patient/addPatient").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_PATIENT)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		Patient result = this.mapper.readValue(resultString, Patient.class);
		assertThat(result).isEqualTo(TEST_PATIENT);
	}

	@Test
	public void testPatientById() throws Exception {
		this.mockMVC.perform(get("/patient/patientById/3")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_PATIENT)));

	}

	@Test
	public void testZZZ() throws Exception {
		final List<Patient> PATIENTS = new ArrayList<>();
		PATIENTS.add(TEST_SAVED_PATIENT);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/patient/allp").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Patient> results = Arrays.asList(mapper.readValue(resultString, Patient[].class));
		assertThat(results).contains(this.TEST_PATIENT).hasSize(3);
	}

	@Test
	public void testUpdatePatient() throws Exception {
		final Patient newPatient = new Patient();
		String resultString = this.mockMVC
				.perform(put("/patient/updatePatient/3").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newPatient)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Patient result = this.mapper.readValue(resultString, Patient.class);
		assertThat(result).isEqualTo(newPatient);
	}

	@Test
	public void testDeletePatient() throws Exception {
		this.mockMVC.perform(delete("/patient/deletePatient/2")).andExpect(status().isNoContent());
	}
}