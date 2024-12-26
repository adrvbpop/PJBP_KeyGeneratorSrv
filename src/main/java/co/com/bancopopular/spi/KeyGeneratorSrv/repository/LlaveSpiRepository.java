package co.com.bancopopular.spi.KeyGeneratorSrv.repository;

import co.com.bancopopular.spi.KeyGeneratorSrv.entity.LlaveSpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LlaveSpiRepository extends JpaRepository<LlaveSpi, Long> {
    Optional<LlaveSpi> findByNumeroIdentificacion(String numeroIdentificacion);
    boolean existsByNumeroLlave(String numeroLlave);

    @Transactional
    @Modifying
    @Query("update LlaveSpi l set l.numeroLlave = ?1 where l.numeroLlave = ?2")
    int updateNumeroLlaveByNumeroLlave(String numeroLlave);

    @Transactional
    @Modifying
    @Query("update LlaveSpi l set l.numeroLlave = ?1 where l.numeroIdentificacion = ?2")
    int updateNumeroLlaveByNumeroIdentificacion(String numeroLlave, String numeroIdentificacion);
}