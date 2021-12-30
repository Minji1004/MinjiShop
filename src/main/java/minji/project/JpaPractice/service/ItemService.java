package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.repository.ItemRepository;
import minji.project.JpaPractice.web.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Long registerItem(ItemDTO itemDTO) {
      //  return itemRepository.saveItem(itemDTO.toItemEntity());
        Item item = itemRepository.save(itemDTO.toItemEntity());
        return item.getId();
    }

    public List<ItemDTO> findItems() {

        List<Item> itemList = itemRepository.findAll();

        //DTO로 변환
        List<ItemDTO> items = new ArrayList<ItemDTO>();
        for (Item item : itemList) {
            items.add(new ItemDTO(item));
        }

        return items;
    }

    public ItemDTO findItemById(Long id) throws Exception {
      //  Item item = itemRepository.findItemById(id);
        Item item = itemRepository.findById(id).orElseThrow(()->new Exception("해당 아이템이 없습니다."));
        return new ItemDTO(item);
    }

    public Long update(Long id, ItemDTO requestDto) {
        Item item = requestDto.toItemEntity();
        item.setItemId(id);

        item = itemRepository.save(item);

        return item.getId();
    }

    public void delete(Long id) throws Exception {
        Item item = itemRepository.findById(id).orElseThrow(()->new Exception("해당 아이템이 없습니다."));
        //엔티티 삭제
        itemRepository.delete(item);
    }
}
