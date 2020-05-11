package ade.web;

import ade.beans.Formation;
import ade.beans.Metier;
import ade.repository.ServiceADE;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class DBConstructController {

	@Autowired
	private ServiceADE dao;

	@PostConstruct
	//@RequestMapping(value = "/build", method = RequestMethod.GET)
	public void build() {
		try {
			System.err.println("DEBUT BUILD BDD");
			Resource resource = new ClassPathResource("asso_metier_secteur.xlsx");
			InputStream inputStream = resource.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			/*On efface ce qui a été précédemmennt mis sur la BDD*/
			dao.clearAll();

			XSSFSheet worksheet = workbook.getSheetAt(2);

			/*On récup la feuille 3 du fichier xlsx*/
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = worksheet.getRow(i);
				if(row.getCell(1)==null) {
					System.err.println("SECTEUR :" +row.getCell(0).toString()+" "+ row.getCell(1)+" "+row.getCell(2).toString());
					dao.saveSecteur(row.getCell(2).toString(), row.getCell(0).toString());
				}
					else {
					System.err.println("SOUS-SECTEUR :" +row.getCell(0).toString()+" "+ row.getCell(1).toString()+" "+row.getCell(2).toString());
					dao.saveSous_Secteur(row.getCell(2).toString(), row.getCell(1).toString(), row.getCell(0).toString());
				}
				}

			/* On récupère la feuille 1 du fichier xlsx */
			worksheet = workbook.getSheetAt(0);
			
			Metier metier;
			Formation formation;

			/* On omets la 1ère ligne */
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

				XSSFRow row = worksheet.getRow(i);

				metier = new Metier(row.getCell(8).toString(), row.getCell(7).toString());
				formation = new Formation(row.getCell(4).toString(), row.getCell(2).toString(),
						row.getCell(1).toString(), row.getCell(3).toString());

				/* Le secteur et sous-secteur sont séparé par '/' dans la feuille excel */
				String[] sectEtSousSect = row.getCell(6).toString().split("/");


				dao.saveAssociationInSousSecteur(metier, formation, sectEtSousSect[1]);

			}
		} catch (IOException e) {
			System.err.println(("IOException" + e));
		}
		System.err.println("FIN BUILD BDD");
	}

}
