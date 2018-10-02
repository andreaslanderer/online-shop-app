package com.landerer.osa.product;

import com.landerer.osa.commons.interceptor.OsaHystrixExecutionInterceptor;
import com.landerer.osa.main.MainApp;
import com.netflix.hystrix.strategy.HystrixPlugins;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest(classes = MainApp.class)
public class GetProductsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        HystrixPlugins.getInstance().registerCommandExecutionHook(new OsaHystrixExecutionInterceptor());
    }

    @Test
    public void shouldReturnStatusOk() throws Exception {
        final String rid = UUID.randomUUID().toString();
        final String sid = UUID.randomUUID().toString();
        this.mockMvc.perform(
                get("/products")
                        .header("rid",rid)
                        .header("sid", sid))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
