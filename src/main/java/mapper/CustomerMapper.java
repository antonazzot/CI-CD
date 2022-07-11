package mapper;

import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.CustomerRequst;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mappings({
            @Mapping(target="name", source="customerName"),
            @Mapping(target="balance", source="customerBalance")
    })
    Customer customerRequstToCustomer (CustomerRequst customerRequst);
}
