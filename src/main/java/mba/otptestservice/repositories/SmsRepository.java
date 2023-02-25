package mba.otptestservice.repositories;

import mba.otptestservice.models.dbs.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepository extends JpaRepository<Sms, Long> {

}
