package com.jadm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jadm.model.BbookEnvioOc;
import com.jadm.model.BbookPo;


@Repository
public interface BbookEnvioOcRepository extends CrudRepository<BbookEnvioOc, String> {

	List <BbookEnvioOc> findByPmgPoNumber(long pmgPoNumber);
	//List <BbookEnvioOc> findByDistinctPmgPoNumber();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update app_sam.sdi_sdipmghde s set s.download_date_1 = sysdate where pmg_po_number = :pmg_po_number", nativeQuery = true)
    public void updSdipmghde(@Param("pmg_po_number") long pmg_po_number);

	
	@Modifying(clearAutomatically = true)
	//@Query(value = "select distinct rowid idd, pmg_po_number, '1' id_document, '1' prd_upc,'1' prd_lvl_number,'1' prd_name_full,'1' prd_desc,'1' prd_lvl_parent_num,'1' prd_pdd_code_1,'1' prd_pdd_code_2,'1' prd_pdd_code_3,'1' prc_price1,'1' prc_price2 ,'1' value ,'1' proforma_invoice,'1' status ,'1' error from app_sam.sdi_sdipmghde where tran_type = 'A' and   pmg_stat_code = 4 and   download_date is null and   pmg_ext_po_num is null and pmg_po_number = 468", nativeQuery = true)
	@Query(value = "select distinct pmg_po_number from app_sam.sdi_sdipmghde where tran_type = 'A' and   pmg_stat_code = 4 and   download_date_1 is null and   pmg_ext_po_num is not null", nativeQuery = true)
	List <String> selSdipmghde();
	
}
