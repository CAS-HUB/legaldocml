package io.legaldocml.validation.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.legaldocml.akn.AknObject;
import io.legaldocml.akn.AkomaNtoso;
import io.legaldocml.akn.DocumentType;
import io.legaldocml.validation.Rule;
import io.legaldocml.validation.ValidationContext;
import io.legaldocml.validation.ValidationError;

/**
 * @author <a href="mailto:jacques.militello@gmail.com">Jacques Militello</a>
 */
final class ValidationsDefaultContext<T extends DocumentType> implements ValidationContext {

	/**
	 * SLF4J Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationsDefaultContext.class);

	/**
	 * Holder for akomaNtoso Object.
	 */
	private final AkomaNtoso<T> akomaNtoso;
	
	/**
	 * Holder for all errors found.
	 */
	private final Map<Rule, List<ValidationError>> errors;

	/**
	 * Holder for all params for this context.
	 */
	private final Map<String, Object> contextHolder;

	ValidationsDefaultContext( AkomaNtoso<T> akomaNtoso) {
		this.akomaNtoso = akomaNtoso;
		this.errors = new HashMap<>();
		this.contextHolder = new HashMap<>();
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
	@SuppressWarnings("unchecked")
	public AkomaNtoso<T> getAkomaNtoso() {
		return this.akomaNtoso;
	}

	/**
     * {@inheritDoc}
     */
    @Override
	public void addError(Rule rule, AknObject node, String message) {
		LOGGER.info("error from rule [{}] -> node [{}] -> [{}]", rule, node, message);
		this.errors.computeIfAbsent(rule, r -> new LinkedList<>()).add(Validations.error(rule, node, message));
		
	}

	/**
     * {@inheritDoc}
     */
    @Override
	public int getErrorCount() {
		// @formatter:off
		return this.errors.values()
				.stream()
				.mapToInt(List::size)
				.reduce(Integer::sum)
				.orElse(0);
		// @formatter:on
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Object> getContextHolder() {
		return this.contextHolder;
	}

}
