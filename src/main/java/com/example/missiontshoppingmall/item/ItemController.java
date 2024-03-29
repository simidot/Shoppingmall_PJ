package com.example.missiontshoppingmall.item;

import com.example.missiontshoppingmall.item.dto.ItemInfoDto;
import com.example.missiontshoppingmall.item.dto.ItemRequest;
import com.example.missiontshoppingmall.item.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shopping-malls/{mallId}")
public class ItemController {
    private final ItemService itemService;

    // 쇼핑몰 상품 등록 (주인)
    @PostMapping
    public ItemResponse uploadItem(
            @PathVariable("mallId") Long id,
            @RequestPart("file") List<MultipartFile> multipartFile,
            @RequestPart ItemRequest dto
    ) {
        return itemService.createItem(multipartFile, id, dto);
    }

    // 상품 수정
    @PutMapping("/items/{itemId}")
    public ItemResponse updateItem(
            @PathVariable("mallId") Long mallId,
            @PathVariable("itemId") Long itemId,
            @RequestPart("file") List<MultipartFile> multipartFile,
            @RequestPart ItemRequest dto
    ) {
        return itemService.updateItem(multipartFile, mallId, itemId, dto);
    }

    // 상품 삭제
    @DeleteMapping("/items/{itemId}")
    public String deleteItem(
            @PathVariable("mallId") Long mallId,
            @PathVariable("itemId") Long itemId
    ) {
        itemService.deleteItem(mallId, itemId);
        return "상품 삭제 완료";
    }

    // 상품 검색 (이름, 가격범위 기준으로 상품 검색 가능)
    @GetMapping("/search")
    public List<ItemInfoDto> searchItem(
            @PathVariable("mallId") Long mallId,
            @RequestParam("q") String q,
            @RequestParam("cat") String category
    ) {
        return itemService.searchItem(mallId, q, category);
    }
}
