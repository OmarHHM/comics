package com.albo.comics.scheduler;

import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.albo.comics.scheduler.repository.HeroRepository;
import com.albo.comics.scheduler.service.OperationServiceImpl;
import com.albo.comics.scheduler.util.ApiException;
import com.albo.comics.scheduler.util.Constants;
import com.albo.comics.scheduler.util.Util;


@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory
			                            .getLogger(ScheduledTask.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private OperationServiceImpl operationService;
	
	@Autowired
	private HeroRepository repository;
	
	
	@PostConstruct
	public void insertData() {
		try {
			log.info("Starting insert data comics job...");
			var iroman    = operationService.getData(Constants.IROMAN);
			var capAmerica= operationService.getData(Constants.CAPAMERICA);
			iroman.setLastSync(Util.getDatetime());
			capAmerica.setLastSync(Util.getDatetime());			
			repository.save(iroman);
			repository.save(capAmerica);
			log.info("End success insert data comics job...");
		} catch (Exception e) {
			log.info("Error al ejecutar job ---->" + e );
		}
	}
	
	
	@Scheduled(cron = "0 0 0 1/1 * ?")
	public void updateData() {
		try {
			log.info("Starting updateData comics job..");
			var iroman    = operationService.getData(Constants.IROMAN);
			var capAmerica= operationService.getData(Constants.CAPAMERICA);
			iroman.setLastSync(Util.getDatetime());
			capAmerica.setLastSync(Util.getDatetime());			
			repository.save(iroman);
			repository.save(capAmerica);
			log.info("End updateData comics job..");
		} catch (ApiException exception) {
			log.info("Error APiException Job ---->" + exception );
		} catch (Exception e) {
			log.info("Error al ejecutar job ---->" + e );
		} 
	}
}