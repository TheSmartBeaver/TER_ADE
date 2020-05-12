package ade.web;

import ade.beans.Formation;
import ade.beans.Metier;
import ade.beans.Secteur;
import ade.beans.SousSecteur;
import ade.repository.ServiceADE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DbRestController {
    @Autowired
    private ServiceADE serviceAde;

    /*Retourne un JSON contenant tous les secteurs*/
    @GetMapping("/secteursList")
    public List<Secteur> getSecteurs() {
        System.err.println("On demande la liste de tous les secteurs");
        return serviceAde.findAllSecteur();
    }

    /*Retourne un JSON contenant tous les Sous-secteurs*/
    @GetMapping("/sousSecteursList")
    public List<SousSecteur> getSousSecteurs(@RequestParam(value = "codeS", defaultValue = "-1") String value) {
        System.err.println("La liste des sous-secteurs du secteur : "+value);
        return serviceAde.findAllSSOfS(value);
    }

    /*Retourne un JSON contenant tous les Sous-secteurs*/
    @GetMapping("/metiersList")
    public HashSet<Metier> getMetiers(@RequestParam(value = "codeSS", defaultValue = "-1") String value) {
        System.err.println("La liste des métiers du SS : "+value);
        return serviceAde.findAllMetierOfSS(value);
    }

    /*Retourne un JSON contenant tous les Sous-secteurs*/
    @GetMapping("/formationsList")
    public HashSet<Formation> getFormations(@RequestParam(value = "codeSS", defaultValue = "-1") String codeSS,
                                            @RequestParam(value = "metierCode", defaultValue = "-1") String codeMetier) {
        System.err.println("La liste des formations du SS : "+codeSS+" pour le métier "+codeMetier);
        return serviceAde.findAllFormationOfMetierinSS(codeSS,codeMetier);
    }
}
