package in.sourav.library.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sourav.library.restservice.model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower,Integer>{

	public List<Borrower> findByBorrowerName(String user);
}