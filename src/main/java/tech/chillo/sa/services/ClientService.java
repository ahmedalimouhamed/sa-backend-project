package tech.chillo.sa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.repositoty.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
        Client clientExist = this.clientRepository.findByEmail(client.getEmail());
        if(clientExist == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientACreer){
        Client clientExist = this.clientRepository.findByEmail(clientACreer.getEmail());
        if(clientExist == null) {
            clientExist = this.clientRepository.save(clientACreer);
        }
        return clientExist;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifier(int id, Client client) {
        Client clientAModifier = this.lire(id);
        if(clientAModifier.getId() == client.getId()){
            clientAModifier.setEmail(client.getEmail());
            clientAModifier.setTelephone(client.getTelephone());
            this.clientRepository.save(clientAModifier);
        }
    }
}
