package kpp.rest;

import org.springframework.data.repository.CrudRepository;

public interface CopyRepository extends CrudRepository<Copy, Integer> {
    Copy findCopyByContent1AndContent2AndContent3(String content1, String content2, String content3);
}
