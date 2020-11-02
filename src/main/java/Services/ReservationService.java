package Services;

import DAO.MaterielDao;
import DAO.ReservationDao;
import entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import serviceInterface.ReservationServiceInterface;

import java.util.List;
import java.util.Optional;

public class ReservationService implements ReservationServiceInterface {
    @Autowired
    private ReservationDao reservationDao;
    @Override
    public Optional<Reservation> findbyid(long id) {
        return reservationDao.findById(id);
    }

    @Override
    public List<Reservation> findall() {
        return reservationDao.findAll();
    }

    @Override
    public int save(Reservation reservation) {
        if(reservation!=null){
            reservationDao.save(reservation);
            return 0;
        }else return 1;
    }

    @Override
    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);

    }
}
