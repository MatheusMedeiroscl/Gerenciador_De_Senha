package com.medeiros.gerenciadordesenha;

import com.medeiros.gerenciadordesenha.controllers.ClientController;
import com.medeiros.gerenciadordesenha.entities.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorDeSenhaApplication {

	public static void main(String[] args) {
		Client client = new Client("matheus", "math.com", "@mat", "12345");
		ClientController controller = new ClientController();

		controller.create(client);

	}

}
