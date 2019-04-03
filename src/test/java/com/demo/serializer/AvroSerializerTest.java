package com.demo.serializer;

import com.demo.util.AvroSerializer;
import example.avro.User;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class AvroSerializerTest {

    @Test
    public void testSerialize() {
        User user = User.newBuilder().setName("John Doe").setFavoriteColor("green")
                .setId(null).build();

        AvroSerializer<User> avroSerializer = new AvroSerializer<>();
        assertThat(avroSerializer.serialize("avro.t", user))
                .isEqualTo(DatatypeConverter.parseHexBinary("104A6F686E20446F6502000A677265656E"));

        avroSerializer.close();
    }
}
