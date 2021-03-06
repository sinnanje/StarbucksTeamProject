package starbucks.starbucksteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import starbucks.starbucksteam.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p where p.card.cardid = ?1")
    List<Payment> findAllForCard(Integer cardId);

    @Query("select p from Payment p where p.card.user.email = ?1")
    List<Payment> findAllForUser(String email);

}
