package com.jadm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jadm.model.BbookEnvioOc;
import com.jadm.model.BbookPo;
import com.jadm.model.JsonCab;
import com.jadm.model.JsonData;
import com.jadm.model.JsonDet;
import com.jadm.repository.BbookEnvioOcRepository;
import com.jadm.utilities.HttpUtilities;

@Service
@Transactional
public class BbookService {

	@Value("${api_url}")
	private String apiurl;

	@Value("${token_uri}")
	private String token;
	
	@Autowired
	BbookEnvioOcRepository bbookenvioocrepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(BbookService.class);

	public void EnvioOc() {
		 
		 Gson g = new Gson();
		 JsonCab jsoncab=null;
		 JsonData jsondata=null;
		 String responses=null;
		 List<JsonDet> json=new ArrayList<>();
		 HttpEntity<String> entity=null;
		 List<BbookEnvioOc> bbookenvocResult= null;
		 List<String> bbookpoResult =  bbookenvioocrepository.selSdipmghde();
//		 List<BbookEnvioOc> bbookpoResult =  bbookenvioocrepository.findByDistinctPmgPoNumber();
		 
		 
	 try{
	     //for (String row : bbookpoResult) {
		 for (int x = 0; x < bbookpoResult.size(); x++) {
	    	 bbookenvocResult = bbookenvioocrepository.findByPmgPoNumber(Long.parseLong(bbookpoResult.get(x)));
             long varpoNumber = 0;
             long varidDocument = 0;
             long varstatus = 0;
             String varerror = null;
             
	    	 for (BbookEnvioOc line : bbookenvocResult) {
	    		  //String.valueOf
	    		  json.add(new JsonDet(String.valueOf(line.getPrdUpc()),line.getPrdLvlNumber(), line.getPrdNameFull(),line.getPrdDesc(), line.getPrdLvlParentNum(),line.getPrdPddCode1(), line.getPrdPddCode2(), line.getPrdPddCode3(), String.valueOf(line.getPmgPoNumber()), line.getProformaInvoice(), String.valueOf(line.getPrcPrice1()), String.valueOf(line.getPrcPrice2()), line.getValue()));
	    		  
	    		  varpoNumber=line.getPmgPoNumber();
	              varidDocument=line.getPmgExtPoNum();
	              varstatus=line.getStatus();
	              varerror=line.getError();
	    	 }
	    	 
	            jsoncab = new JsonCab(varidDocument, String.valueOf(varpoNumber), json, varstatus,varerror);
	            jsondata = new JsonData(jsoncab);
	            		  
	     
	     
	       // create full entity.
	 	   HttpHeaders headers = new HttpHeaders();
	 	   headers.set("user-agent", "Application");
	 	   //headers.set("cache-control", "no-cache");
	 	   
	 	   headers.setContentType(MediaType.APPLICATION_JSON);
	 	   //headers.set("Authorization", "Bearer " + token);
	 	   headers.set("X-Bbook-Token",token);
	 	   //headers.set("Authorization", token);
 	    
    	   // create entity, headers + body
 		   entity = new HttpEntity<String>(g.toJson(jsondata), headers);
	 	  // entity = new HttpEntity<String>(g.toJson("\"data\": [{\"id\":\"80\",\"name\":\"Recoleta\",\"inactive\":\"true\",\"is_warehouse\":\"false\"},{\"id\":\"71\",\"name\":\"Eccommerce\",\"inactive\":\"true\",\"is_warehouse\":\"false\"}]"), headers);

 		 try {
 		     responses = HttpUtilities.BulkUpdateApiPoster(entity, apiurl);
         }catch (Exception e) {
         	LOG.error("Error al enviar datos", e);
         
         	responses="No se pudo informar tienda";
         }
           
 		bbookenvioocrepository.updSdipmghde(varpoNumber);
 		 
		 }  
		   
     }catch (Exception e) {
     	LOG.error("Error al cargar json", e);
     }
        


   }
}
