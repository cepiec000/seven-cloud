package cc.seven.admin.controller;

import cc.seven.admin.annotation.ControllerEndpoint;
import cc.seven.admin.entity.LoginLog;
import cc.seven.admin.service.ILoginLogService;
import cc.seven.common.core.entity.ApiResult;
import cc.seven.common.core.entity.admin.QueryRequest;
import cc.seven.common.core.utils.SevenUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author Seven
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("loginLog")
public class LoginLogController {

    private final ILoginLogService loginLogService;

    @GetMapping
    public ApiResult loginLogList(LoginLog loginLog, QueryRequest request) {
        Map<String, Object> dataTable = SevenUtil.getDataTable(this.loginLogService.findLoginLogs(loginLog, request));
        return ApiResult.success(dataTable);
    }

    @GetMapping("currentUser")
    public ApiResult getUserLastSevenLoginLogs() {
        String currentUsername = SevenUtil.getCurrentUsername();
        List<LoginLog> userLastSevenLoginLogs = this.loginLogService.findUserLastSevenLoginLogs(currentUsername);
        return ApiResult.success(userLastSevenLoginLogs);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('loginlog:delete')")
    @ControllerEndpoint(operation = "删除登录日志", exceptionMessage = "删除登录日志失败")
    public void deleteLogs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] loginLogIds = ids.split(StringPool.COMMA);
        this.loginLogService.deleteLoginLogs(loginLogIds);
    }

}
