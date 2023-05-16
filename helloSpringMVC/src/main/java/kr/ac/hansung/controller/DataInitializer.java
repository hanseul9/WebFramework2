package kr.ac.hansung.controller;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {

    @Autowired
    private OfferDao offerDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        Offer offer1 = new Offer("Alice", "alice@hansung.ac.kr", "스프링이 참 재밌네요");
        Offer offer2 = new Offer("Bob", "bob@hansung.ac.kr", "JPA/Hibernate가 편리하네요");
        Offer offer3 = new Offer("Charlie", "charlie@hansung.ac.kr", "Rest API 구현");

        offerDao.insert(offer1);
        offerDao.insert(offer2);
        offerDao.insert(offer3);
    }
}
