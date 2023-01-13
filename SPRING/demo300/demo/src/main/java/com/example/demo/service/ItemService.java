package com.example.demo.service;


import com.example.demo.controller.task2.BitlabItems;
import com.example.demo.controller.task2.BitlabSubject;
import com.example.demo.controller.task2.ItemRepository;
import com.example.demo.controller.task2.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public BitlabItems addItem(BitlabItems item){
       item = itemRepository.save(item);
        return item;
    }

    public BitlabItems getItems(Long id){
       return itemRepository.findById(id).orElse(null);
    }


    public BitlabItems assignSubject(Long itemId, Long subjectId){
        BitlabItems item = itemRepository.findById(itemId).orElseThrow();
        BitlabSubject subject = subjectRepository.findById(subjectId).orElseThrow();


        List<BitlabSubject> subjects=item.getSubjects();
        if(subjects==null){
            subjects=new ArrayList<>();
        }
        subjects.add(subject);
        return itemRepository.save(item);
    }

    public BitlabItems unAssignSubject(Long itemId, Long subjectId){
        BitlabItems item = itemRepository.findById(itemId).orElseThrow();
        BitlabSubject subject = subjectRepository.findById(subjectId).orElseThrow();


        List<BitlabSubject>subjects=item.getSubjects();
        if(subjects==null){
            subjects=new ArrayList<>();
        }
        subjects.remove(subject);
        return itemRepository.save(item);
    }

    public List<BitlabItems> search(String key, String order){
        List<BitlabItems> items = null;
        if(order!=null){
            if(order.equals("desk")){
                items = itemRepository.searchItemsDesk("%"+key.toLowerCase()+"%");
            }
        }
        if(items==null){
            items = itemRepository.searchItemsAsc("%"+key.toLowerCase()+"%");
        }
        return items;
    }

    public void deleteItem(BitlabItems item){
        itemRepository.deleteById(item.getId());
    }

    public BitlabItems saveItem(BitlabItems item){
        item = itemRepository.save(item);
        return item;
    }

    public List<BitlabItems>getAllItems(){
        return itemRepository.findAll();
    }
}
