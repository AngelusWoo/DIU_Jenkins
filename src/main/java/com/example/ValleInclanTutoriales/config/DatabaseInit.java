package com.example.ValleInclanTutoriales.config;

import com.example.ValleInclanTutoriales.model.Tutorial;
import com.example.ValleInclanTutoriales.model.TutorialRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Tras descomentar la funcion en esta clase, insertara datos predefinidos
 * en la base de datos al iniciar la aplicacion. Si hay datos con el mismo
 * ID que estos datos, seran sobreescritos.
 */

@Slf4j
@Component
public class DatabaseInit {
	@Autowired
    public TutorialRepository repository;

	/*@PostConstruct
	public void createData() {
        Tutorial t1 = new Tutorial("TEST01","Titulo1","Description",false);
        Tutorial t2 = new Tutorial("TEST02","Title1","Description",true);
        Tutorial t3 = new Tutorial("TEST03","Test1","Description",false);
        Tutorial t4 = new Tutorial("TEST04","Titulo2","Description",false);
        Tutorial t5 = new Tutorial("TEST05","Title2","Description",true);
        Tutorial t6 = new Tutorial("TEST06","Test2","Description",false);
        Tutorial t7 = new Tutorial("TEST07","Titulo3","Description",true);
        Tutorial t8 = new Tutorial("TEST08","Yes","Description",false);
        log.info("Inserting tutorials...");
        repository.save(t1); repository.save(t2);
        repository.save(t3); repository.save(t4);
        repository.save(t5); repository.save(t6);
        repository.save(t7); repository.save(t8);
	}*/
}