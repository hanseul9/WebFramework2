package kr.ac.hansung.service;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    // service -> dao
    @Autowired
    private OfferDao offerDao;

    public List<Offer>  getCurrent() {
        return offerDao.getOffers();
    }

    public void insert(Offer offer) {
        offerDao.insert(offer);
    }
}
