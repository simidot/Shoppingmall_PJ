package com.example.missiontshoppingmall.shoppingMall;

import com.example.missiontshoppingmall.shoppingMall.dto.MallCloseRequest;
import com.example.missiontshoppingmall.shoppingMall.dto.MallCloseResponse;
import com.example.missiontshoppingmall.shoppingMall.dto.MallOpenRequest;
import com.example.missiontshoppingmall.shoppingMall.dto.MallOpenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shopping-mall")
public class ShoppingMallController {
    private final ShoppingMallService mallService;

    // 쇼핑몰 개설
    // 사업자 사용자로 전환되며 준비중 상태의 쇼핑몰이 추가된 상태
    @PostMapping("/{mallId}/open-request")
    public MallOpenResponse openRequest(
            @PathVariable("mallId") Long id,
            @RequestBody MallOpenRequest requestDto
    ) {
        return mallService.createOpenRequest(id, requestDto);
    }

    // 쇼핑몰 정보수정 (주인)
    @PutMapping("/{mallId}")
    public MallOpenResponse updateMall(
            @PathVariable("mallId") Long id,
            @RequestBody MallOpenRequest request
    ) {
        return mallService.updateMallInfo(id, request);
    }

    // 쇼핑몰 폐쇄요청 (주인)
    @PostMapping("/{mallId}/close-request")
    public MallCloseResponse closeMall(
            @PathVariable("mallId") Long id,
            @RequestBody MallCloseRequest dto
    ) {
        return mallService.closeRequest(id, dto);
    }
}