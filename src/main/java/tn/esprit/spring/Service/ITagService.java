package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Tag;

import java.util.List;

public interface ITagService {
    public Long ajouterTag(Tag tag);
    public void deleteTag(Long tagId);
    public List<Tag> getTags();
    public Long modifierTag(Tag tag);
    public Tag getTag(Long tagId);
}
