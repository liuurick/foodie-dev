package com.liubin.generate.service;

import com.fengwenyi.api.result.ResponseTemplate;
import com.liubin.generate.vo.CodeGeneratorRequestVO;

public interface IndexService {

    /**
     * ็ๆไปฃ็ 
     * @param requestVo
     * @return
     */
    ResponseTemplate<Void> codeGenerator(CodeGeneratorRequestVO requestVo);

}
