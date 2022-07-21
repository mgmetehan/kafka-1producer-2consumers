package com.mgmetehan.kafkaconsumer2.config;

import java.util.HashMap;
import java.util.Map;

import com.mgmetehan.kafkaconsumer2.dto.KMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConfiguration {
    @Value("${mg.kafka.address}")
    private String kafkaAddress;
    @Value("${mg.kafka.group.id}")
    private String groupId;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KMessage> factory2 = new ConcurrentKafkaListenerContainerFactory<>();
        factory2.setConsumerFactory(consumerFactory());
        return factory2;
    }

    @Bean
    public ConsumerFactory<String, KMessage> consumerFactory() {
        Map<String, Object> props2 = new HashMap<>();
        props2.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props2.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props2.put(JsonDeserializer.VALUE_DEFAULT_TYPE, KMessage.class);
        props2.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props2.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props2);
    }
}