package com.ota.notetaking.repository;

import com.ota.notetaking.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Modifying
    @Query("update Note n set n.title = :title, n.body = :body where n.id = :id")
    public void updateNoteById(@Param("title") String title,
                               @Param("body") String body,
                               @Param("id") Long id);

}
