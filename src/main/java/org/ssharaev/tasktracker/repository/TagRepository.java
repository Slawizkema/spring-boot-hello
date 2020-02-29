package org.ssharaev.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssharaev.tasktracker.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
