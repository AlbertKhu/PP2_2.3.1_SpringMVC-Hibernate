package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
//@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

}
